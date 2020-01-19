package com.mhasan.udct.popmovies.utils;

/**
 * This is the interface used to create the concrete factory class that produces a product.
 *
 * @param <P> is the product.
 * @author Mahmudul Hasan.
 */
public interface UtilsFactory<P> {

	P create();

}
