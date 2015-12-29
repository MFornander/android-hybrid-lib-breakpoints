# Android Breakpoints in Shared Library C++ and Java Code
Android Studio, Gradle-only, Breakpoints in Native Library Code

Spike on getting hybrid code across multiple modules to not only build using only Gradle but also allow native shared library breakpoints to be hit.

1. Add breakpoints at the four TODO spots but especially in hybridlib's nativelib.c
2. Edit Configurations... and add library symbol path to the Hybrid Debugger such as:
   $PROJECT_DIR$/hybridlib/build/intermediates/binaries/debug/obj/x86_64   or
     or
   $PROJECT_DIR$/hybridlib/build/intermediates/binaries/debug/obj/arm64-v8a
3. Hit Debug and select your adb target to deploy.  Tested on arm phone, x86_64 emulator, and arm64-v8 test board.
4. Wait for the debugger to connect and hit the pink mail action button in the deployed android app.
5. Watch all breakpoints being hit, one by one by hitting "Resume Program" aech time a BP is hit.


This was a little hard and most lines in the build.gradle files are required for the native library breakpoint to resolve in LLDB.

