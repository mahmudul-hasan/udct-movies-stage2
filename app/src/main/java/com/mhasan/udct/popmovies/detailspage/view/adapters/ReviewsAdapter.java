package com.mhasan.udct.popmovies.detailspage.view.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.mhasan.udct.popmovies.R;
import com.mhasan.udct.popmovies.detailspage.repository.model.ReviewsResponse;

/**
 * Adapter class for reviews.
 *
 * @author Mahmudul Hasan.
 */
public class ReviewsAdapter extends BaseExpandableListAdapter {

	private Context context;
	private List<ReviewsResponse.ResultsBean> reviews;

	public ReviewsAdapter(Context context, List<ReviewsResponse.ResultsBean> reviews) {
		this.context = context;
		this.reviews = reviews;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return reviews.get(groupPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return groupPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		String reviewBody = reviews.get(groupPosition).getContent();
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.review_body, null);
		}
		TextView reviewBodyTv = convertView.findViewById(R.id.reviewTextTv);
		reviewBodyTv.setText(reviewBody);
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return reviews.size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return reviews.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return reviews.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		String reviewerName = reviews.get(groupPosition).getAuthor();
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.review_title, null);
		}
		TextView revirerNameTv = convertView.findViewById(R.id.reviewerNameTv);
		revirerNameTv.setText(reviewerName);
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}
}
