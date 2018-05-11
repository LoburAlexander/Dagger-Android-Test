package com.testdagger.di.qualifiers;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Marker qualifier to indicate methods that create new instances of {@link android.arch.lifecycle.ViewModel}
 *
 * <br/><br/>
 * Created by alex.lobur on 5/11/18.
 */

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ViewModelCreator {
}
