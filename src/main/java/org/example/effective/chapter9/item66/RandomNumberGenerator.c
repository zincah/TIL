#include "org_example_effective_chapter9_item66_RandomNumberGenerator.h"
#include <stdlib.h>
#include <time.h>

JNIEXPORT jint JNICALL
Java_org_example_effective_chapter9_item66_RandomNumberGenerator_nativeNextInt
(JNIEnv *env, jobject thisObj, jint bound) {
    srand((unsigned int)time(NULL));
    return rand() % bound;
}