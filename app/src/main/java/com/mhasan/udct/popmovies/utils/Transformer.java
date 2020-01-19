package com.mhasan.udct.popmovies.utils;

/**
 * This is the transformer interface used to create concrete object transformer class.
 *
 * @param <O> is the original object to be transformed.
 * @param <T> is the transformed object.
 * @author Mahmudul Hasan.
 */
public interface Transformer<O, T> {

	T transform(O original);

}
