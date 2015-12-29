#include <string.h>
#include <jni.h>

jstring
Java_com_example_hybridlib_LibUtil_helloCpp( JNIEnv* env, jobject thiz )
{
#if defined(__arm__)
    #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #if defined(__ARM_PCS_VFP)
        #define ABI "armeabi-v7a/NEON (hard-float)"
      #else
        #define ABI "armeabi-v7a/NEON"
      #endif
    #else
      #if defined(__ARM_PCS_VFP)
        #define ABI "armeabi-v7a (hard-float)"
      #else
        #define ABI "armeabi-v7a"
      #endif
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
#define ABI "x86"
#elif defined(__x86_64__)
#define ABI "x86_64"
#elif defined(__mips64)  /* mips64el-* toolchain defines __mips__ too */
#define ABI "mips64"
#elif defined(__mips__)
#define ABI "mips"
#elif defined(__aarch64__)
#define ABI "arm64-v8a"
#else
#define ABI "unknown"
#endif

    // Non trivial code to prevent optimization and allow breakpoints
    char  theHello[100] = "libCpp:";
    char* theAbi = ABI;
    strcat(theHello, theAbi);

    // TODO: Native library breakpoint here
    // Must add symbol path to hybrid debugger plus ABI such as:
    // $PROJECT_DIR$/hybridlib/build/intermediates/binaries/debug/obj/x86_64   or
    // $PROJECT_DIR$/hybridlib/build/intermediates/binaries/debug/obj/arm64-v8a
    // See Google Issue: https://code.google.com/p/android/issues/detail?id=197850
    return (*env)->NewStringUTF(env, theHello);
}
