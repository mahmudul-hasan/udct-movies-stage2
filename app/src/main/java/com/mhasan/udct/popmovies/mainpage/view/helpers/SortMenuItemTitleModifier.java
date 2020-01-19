package com.mhasan.udct.popmovies.mainpage.view.helpers;

import android.view.Menu;
import android.view.MenuItem;

import com.mhasan.udct.popmovies.R;
import com.mhasan.udct.popmovies.utils.Modifier;

import androidx.annotation.NonNull;

/**
 * This class takes a Menu object and modifies its title with the given title string.
 *
 * @author Mahmudul Hasan.
 */
public class SortMenuItemTitleModifier implements Modifier<Menu> {

	private final String title;

	public SortMenuItemTitleModifier(@NonNull String title) {
		this.title = title;
	}

	@Override
	public void modify(@NonNull Menu menu) {
		MenuItem item = menu.findItem(R.id.sortMenu);
		item.setTitle(title);
	}
}
