package com.example;

import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.VariableElement;

/**
 * Created by GanChenQ on 2016/11/24.
 */

public class OnClickMethod {
    private ExecutableElement mExecutableElement;
    private int[] mResId;
    private Name mMethodName;

    public OnClickMethod(Element element) throws IllegalArgumentException {
        if (element.getKind() != ElementKind.METHOD) {
            throw new IllegalArgumentException(
                    String.format("Only methods can be annotated with @%s",
                            OnClick.class.getSimpleName()));
        }
        mExecutableElement = (ExecutableElement) element;
        mResId = mExecutableElement.getAnnotation(OnClick.class).value();
        if (mResId == null) {
            throw new IllegalArgumentException(String.format("Must set valid ids for @%s",
                    OnClick.class.getSimpleName()));
        } else {
            for (int id : mResId) {
                if (id < 0) {
                    throw new IllegalArgumentException(String.format("Must set valid id for @%s",
                            OnClick.class.getSimpleName()));
                }
            }
        }
        mMethodName = mExecutableElement.getSimpleName();
        List<? extends VariableElement> parameters = mExecutableElement.getParameters();

        if (parameters.size() > 0) {
            throw new IllegalArgumentException(
                    String.format("The method annotated with @%s must have no parameters",
                            OnClick.class.getSimpleName()));
        }
    }

    public Name getMethodName() {
        return mMethodName;
    }

    public int[] getResIds() {
        return mResId;
    }
}
