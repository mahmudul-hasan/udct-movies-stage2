package com.mhasan.udct.popmovies.detailspage.view.helpers;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ListAdapter;

import com.mhasan.udct.popmovies.utils.Modifier;

/**
 * This class adjusts the review expandable list view size and its contents' height.
 *
 * @author Mahmudul Hasan, with the help of https://stackoverflow.com/questions/17696039/expandablelistview-inside-a-scrollview
 */
public class ReviewsViewAdjuster implements Modifier<ExpandableListView> {

	/**
	 * https://stackoverflow.com/questions/17696039/expandablelistview-inside-a-scrollview
	 *
	 * @param listView
	 * @param group
	 */
	private void adjustReviewContentHeight(ExpandableListView listView, int group) {
		ExpandableListAdapter listAdapter = listView.getExpandableListAdapter();
		int totalHeight = 0;
		int desiredWidth = MeasureSpec.makeMeasureSpec(listView.getWidth(), MeasureSpec.EXACTLY);
		for (int i = 0; i < listAdapter.getGroupCount(); i++) {
			View groupItem = listAdapter.getGroupView(i, false, null, listView);
			groupItem.measure(desiredWidth, MeasureSpec.UNSPECIFIED);
			totalHeight += groupItem.getMeasuredHeight();
			if (((listView.isGroupExpanded(i)) && (i != group))
					|| ((!listView.isGroupExpanded(i)) && (i == group))) {
				for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
					View listItem = listAdapter.getChildView(i, j, false, null, listView);
					listItem.measure(desiredWidth, MeasureSpec.UNSPECIFIED);
					totalHeight += listItem.getMeasuredHeight();
				}
			}
		}
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		int height = totalHeight + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
		if (height < 10) height = 200;
		params.height = height;
		listView.setLayoutParams(params);
		listView.requestLayout();
	}

	/**
	 * https://stackoverflow.com/questions/17696039/expandablelistview-inside-a-scrollview
	 *
	 * @param reviewsListView
	 */
	private void adjustReviewListSize(ExpandableListView reviewsListView) {
		ListAdapter listAdapter = reviewsListView.getAdapter();
		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, reviewsListView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}
		ViewGroup.LayoutParams params = reviewsListView.getLayoutParams();
		params.height = totalHeight
				+ (reviewsListView.getDividerHeight() * (listAdapter.getCount() - 1));
		reviewsListView.setLayoutParams(params);
		reviewsListView.requestLayout();
		reviewsListView.setOnGroupClickListener(new OnGroupClickListener() {
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
				adjustReviewContentHeight(parent, groupPosition);
				return false;
			}
		});
	}

	@Override
	public void modify(ExpandableListView reviewsListView) {
		adjustReviewListSize(reviewsListView);
	}
}
