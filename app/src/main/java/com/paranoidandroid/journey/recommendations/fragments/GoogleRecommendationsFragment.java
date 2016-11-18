package com.paranoidandroid.journey.recommendations.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.model.LatLng;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.paranoidandroid.journey.R;
import com.paranoidandroid.journey.models.ui.GooglePlace;
import com.paranoidandroid.journey.models.ui.Recommendation;
import com.paranoidandroid.journey.network.GooglePlaceSearchClient;
import com.paranoidandroid.journey.recommendations.adapters.RecommendationsListAdapter;
import com.paranoidandroid.journey.recommendations.interfaces.RecommendationsListAdapterClickListener;
import com.paranoidandroid.journey.support.ui.EndlessRecyclerViewScrollListener;
import com.paranoidandroid.journey.support.ui.SpacesItemDecoration;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cz.msebera.android.httpclient.Header;

public class GoogleRecommendationsFragment extends BaseRecommendationsFragment implements
        RecommendationsListAdapterClickListener {

    private String nextToken = null;
    private boolean hasMore = true;

    public static GoogleRecommendationsFragment newInstance(LatLng coordinates, String keyword) {
        Bundle args = new Bundle();
        GoogleRecommendationsFragment fragment = new GoogleRecommendationsFragment();
        args.putParcelable("coordinates", coordinates);
        args.putString("keyword", keyword);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void search() {
        search(null, true);
    }

    private void search(String token, final boolean clearExisting) {
        GooglePlaceSearchClient.search(coordinates.latitude, coordinates.longitude, keyword, token, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                System.out.println(response);
                List<GooglePlace> places = GooglePlace.parseJSON(response);
                nextToken = GooglePlace.parseNextToken(response);
                hasMore = nextToken != null;
                appendItems(places, clearExisting);
            }
        });
    }

    public EndlessRecyclerViewScrollListener getEndlessScrollListener() {
        return new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                Log.d("Google", "onLoadMore:page:"+page+" totalItemsCount:"+totalItemsCount+" hasMore?"+hasMore);
                if (hasMore)
                    search(nextToken, false);
            }
        };
    }

    @Override
    public void onSaveRecommendationClicked(Recommendation r) {

    }

    @Override
    public void onAddRecommendationClicked(Recommendation r) {

    }
}
