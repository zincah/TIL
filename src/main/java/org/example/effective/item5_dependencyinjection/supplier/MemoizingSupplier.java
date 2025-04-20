package org.example.effective.item5_dependencyinjection.supplier;

import java.util.function.Supplier;

/**
 * Supplier를 래핑해서 재사용 가능한 유틸
 * Supplier<T> 를 한번만 실행해서 결과를 캐싱(memoie)하는 유틸 클래스
 */
public class MemoizingSupplier<T> implements Supplier<T> {
    private final Supplier<T> delegate;
    private T value;
    private boolean initialized = false;

    public MemoizingSupplier(Supplier<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public synchronized T get() {
        if(!initialized){
            value = delegate.get();
            initialized = true;
        }
        return value;
    }
}
