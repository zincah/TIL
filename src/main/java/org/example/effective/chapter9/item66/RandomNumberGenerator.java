package org.example.effective.chapter9.item66;

/**
 * 아이템 66 : 네이티브 메서드는 신중히 사용하라
 *
 * 네이티브 메서드란? : C, C++, Rust 등의 네이티브 언어로 작성된 코드를 자바에서 호출할 수 있게하는 JNI(Java Native Interface) 기반 메서드
 * 사용사례 (성능 극대화, 자바에서 접근할수 없는 os 기능 사용, 기존 라이브러리 사용 등)
 *
 * 네이티브 메서드의 단점
 * 1) 타입 안전성 없음 (컴파일러가 타입 오류를 잡아주지 못함)
 * 2) 디버깅 어려움
 * 3) 복잡성 증가 (운영환경에서 고려해야할 파일이 많아짐)
 * 4) 이식성 낮음 (os, cpu아키텍처에 따라 다르게 동작할 수 있음)
 * 5) 보안 이슈
 *
 * --> 가능한 자바로 구현해야 하며 꼭 필요한 경우에는 아래와 같이 네이티브 코드를 자바 코드로 감싸서 추상화 해야함.
 */
public class RandomNumberGenerator {

    // 외부에는 안전한 메서드만 노출 (java api)
    public int nextInt(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException("bound must be positive");
        }
        return nativeNextInt(bound);  // 내부적으로만 네이티브 호출
    }

    // 외부에 노출하지 않는 네이티브 메서드 : Java 메서드와 C 코드(또는 C++)의 네이티브 함수를 연결(바인딩)하는 역할
    // native → 이 키워드는 "이 메서드의 구현은 자바가 아닌 C/C++ 같은 네이티브 언어로 되어 있다"는 뜻
    private native int nativeNextInt(int bound);

    static {
        // 네이티브 라이브러리 로딩 (보통 .so, .dll)
        System.loadLibrary("fastnative"); // libfastnative.so or fastnative.dll or libfastnative.dylib(macos)
    }
}
