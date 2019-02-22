#include <jni.h>
#include <string>
#include <android/log.h>

extern "C" JNIEXPORT jstring JNICALL
Java_com_ahnlab_enginesdk_rc_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

jstring getABI(JNIEnv *env) {

    jclass build = env->FindClass("android/os/Build");

    jclass version = env->FindClass("android/os/Build$VERSION");
    jfieldID versionFI = env->GetStaticFieldID(version, "SDK_INT", "I");
    jint apiVersion = env->GetStaticIntField(version, versionFI);

    jobject result;

    if (apiVersion >= 21) {
        jfieldID suppAPIFI = env->GetStaticFieldID(build, "SUPPORTED_ABIS", "[Ljava.lang.String;");
        __android_log_print(ANDROID_LOG_DEBUG, "EngineManager", "OK");
        jobjectArray auto suppARR = env->GetStaticObjectField(build, suppAPIFI);
        result = env->GetObjectArrayElement((suppARR), 0);
    } else {
        jfieldID cpuFI = env->GetStaticFieldID(build, "CPU_ABI", "Ljava.lang.String;");
        result = env->GetStaticObjectField(build, cpuFI);
    }

    return (jstring) result;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_ahnlab_enginesdk_rc_EngineManagerWrapper_native_1getCurrentABI(JNIEnv *env, jclass type) {
    return getABI(env);
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_rc_EngineManagerWrapper_native_1getInitData(JNIEnv *env, jobject instance,
                                                                      jobject obj,
                                                                      jobject stringBuffer) {

    // TODO

    return 0;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_rc_EngineManagerWrapper_native_1getMaxAPILevel(JNIEnv *env,
                                                                         jobject instance, jint i) {

    // TODO

    return 0;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_rc_EngineManagerWrapper_native_1getMinAPILevel(JNIEnv *env,
                                                                         jobject instance, jint i) {

    // TODO

    return 0;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_rc_EngineManagerWrapper_native_1getVerifyData(JNIEnv *env,
                                                                        jobject instance,
                                                                        jstring str_,
                                                                        jobject stringBuffer) {
    const char *str = env->GetStringUTFChars(str_, 0);

    // TODO

    env->ReleaseStringUTFChars(str_, str);
    return 0;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_rc_EngineManagerWrapper_native_1getVerifyResult(JNIEnv *env,
                                                                          jobject instance,
                                                                          jstring str_,
                                                                          jobject stringBuffer) {
    const char *str = env->GetStringUTFChars(str_, 0);

    // TODO

    env->ReleaseStringUTFChars(str_, str);
    return 0;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_rc_EngineManagerWrapper_native_1getVersion(JNIEnv *env, jobject instance,
                                                                     jint i, jobject stringBuffer) {

    // TODO

    return 0;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_rc_EngineManagerWrapper_native_1getVersionAll(JNIEnv *env,
                                                                        jobject instance, jint i,
                                                                        jobject treeMap) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_rc_EngineManagerWrapper_native_1loadRCEngine(JNIEnv *env,
                                                                       jobject instance, jint i,
                                                                       jstring str_,
                                                                       jstring str2_) {
    const char *str = env->GetStringUTFChars(str_, 0);
    const char *str2 = env->GetStringUTFChars(str2_, 0);

    // TODO

    env->ReleaseStringUTFChars(str_, str);
    env->ReleaseStringUTFChars(str2_, str2);
    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_rc_EngineManagerWrapper_native_1setDebugOption(JNIEnv *env,
                                                                         jobject instance, jint i) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_rc_EngineManagerWrapper_native_1startRootCheck(JNIEnv *env,
                                                                         jobject instance,
                                                                         jobject obj,
                                                                         jobject obj2) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_rc_EngineManagerWrapper_native_1unloadEngine(JNIEnv *env,
                                                                       jobject instance, jint i) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1unloadEngine(JNIEnv *env,
                                                                       jobject instance, jint i) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1stopSendingFiles(JNIEnv *env,
                                                                           jobject instance) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1startScanList(JNIEnv *env,
                                                                        jobject instance,
                                                                        jobject obj, jobject obj2) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1startScanFile(JNIEnv *env,
                                                                        jobject instance,
                                                                        jobject obj, jobject obj2) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1setNetworkType(JNIEnv *env,
                                                                         jobject instance, jint i) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1setDebugOption(JNIEnv *env,
                                                                         jobject instance, jint i) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1setAllowFileSending(JNIEnv *env,
                                                                              jobject instance,
                                                                              jobject obj) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1sendFiles(JNIEnv *env, jobject instance,
                                                                    jobject obj) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1loadEngine(JNIEnv *env, jobject instance,
                                                                     jint i, jstring str_) {
    const char *str = env->GetStringUTFChars(str_, 0);

    // TODO

    env->ReleaseStringUTFChars(str_, str);
    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1getVersionAll(JNIEnv *env,
                                                                        jobject instance, jint i,
                                                                        jobject treeMap) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1getVersion(JNIEnv *env, jobject instance,
                                                                     jint i, jobject stringBuffer) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1getScanStatus(JNIEnv *env,
                                                                        jobject instance,
                                                                        jobject obj) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1getReadyFileCountToSend(JNIEnv *env,
                                                                                  jobject instance) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1getMinAPILevel(JNIEnv *env,
                                                                         jobject instance, jint i) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1getMaxAPILevel(JNIEnv *env,
                                                                         jobject instance, jint i) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jstring JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1getCurrentABI(JNIEnv *env, jclass type) {
    return getABI(env);
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_av_EngineManagerWrapper_native_1cancelScanList(JNIEnv *env,
                                                                         jobject instance) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT void JNICALL
Java_com_ahnlab_enginesdk_SDKManager_native_1setHandler(JNIEnv *env, jclass type, jobject handler) {

    // TODO

}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_SDKManager_native_1sendReport(JNIEnv *env, jclass type, jobject obj) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_SDKManager_native_1getVersion(JNIEnv *env, jclass type, jint i,
                                                        jobject stringBuffer) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT void JNICALL
Java_com_ahnlab_enginesdk_SDKManager_native_1deleteHandler(JNIEnv *env, jclass type) {

    // TODO

}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_SDKManager_native_1createST(JNIEnv *env, jclass type) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_SDKManager_native_1cancelReport(JNIEnv *env, jclass type) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_SDKLogger_native_1setDebugLog(JNIEnv *env, jclass type, jstring str_) {
    const char *str = env->GetStringUTFChars(str_, 0);

    // TODO

    env->ReleaseStringUTFChars(str_, str);
    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_SDKLogger_native_1release(JNIEnv *env, jclass type) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_SDKLogger_native_1logNormal(JNIEnv *env, jclass type, jstring str_,
                                                      jstring str2_) {
    const char *str = env->GetStringUTFChars(str_, 0);
    const char *str2 = env->GetStringUTFChars(str2_, 0);

    // TODO

    env->ReleaseStringUTFChars(str_, str);
    env->ReleaseStringUTFChars(str2_, str2);
    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_SDKLogger_native_1logInstant(JNIEnv *env, jclass type, jstring str_,
                                                       jstring str2_, jstring str3_, jint i) {
    const char *str = env->GetStringUTFChars(str_, 0);
    const char *str2 = env->GetStringUTFChars(str2_, 0);
    const char *str3 = env->GetStringUTFChars(str3_, 0);

    // TODO

    env->ReleaseStringUTFChars(str_, str);
    env->ReleaseStringUTFChars(str2_, str2);
    env->ReleaseStringUTFChars(str3_, str3);
    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_SDKLogger_native_1logDebug(JNIEnv *env, jclass type, jstring str_,
                                                     jstring str2_) {
    const char *str = env->GetStringUTFChars(str_, 0);
    const char *str2 = env->GetStringUTFChars(str2_, 0);

    // TODO

    env->ReleaseStringUTFChars(str_, str);
    env->ReleaseStringUTFChars(str2_, str2);
    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_SDKLogger_native_1initialize(JNIEnv *env, jclass type, jstring str_) {
    const char *str = env->GetStringUTFChars(str_, 0);

    // TODO

    env->ReleaseStringUTFChars(str_, str);
    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_AttachmentMaker_native_1makeAttachment(JNIEnv *env, jobject instance,
                                                                 jstring str_) {
    const char *str = env->GetStringUTFChars(str_, 0);

    // TODO

    env->ReleaseStringUTFChars(str_, str);
    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1unloadEngine(JNIEnv *env,
                                                                       jobject instance, jint i) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1startUpdate(JNIEnv *env, jobject instance,
                                                                      jobject obj, jobject obj2) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1startAuthentication(JNIEnv *env,
                                                                              jobject instance,
                                                                              jobject obj,
                                                                              jobject obj2) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1setDebugOption(JNIEnv *env,
                                                                         jobject instance, jint i) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1loadEngine(JNIEnv *env, jobject instance,
                                                                     jint i, jstring str_) {
    const char *str = env->GetStringUTFChars(str_, 0);

    // TODO

    env->ReleaseStringUTFChars(str_, str);
    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1initUpdater(JNIEnv *env, jobject instance,
                                                                      jstring str_, jint i) {
    const char *str = env->GetStringUTFChars(str_, 0);

    // TODO

    env->ReleaseStringUTFChars(str_, str);
    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1getVersionAll(JNIEnv *env,
                                                                        jobject instance, jint i,
                                                                        jobject treeMap) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1getVersion(JNIEnv *env, jobject instance,
                                                                     jint i, jobject stringBuffer) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1getUpdateInfo(JNIEnv *env,
                                                                        jobject instance,
                                                                        jobject obj) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1getProductCode(JNIEnv *env,
                                                                         jobject instance) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1getOperationFlag(JNIEnv *env,
                                                                           jobject instance) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1getMinAPILevel(JNIEnv *env,
                                                                         jobject instance, jint i) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1getMaxAPILevel(JNIEnv *env,
                                                                         jobject instance, jint i) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jstring JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1getCurrentABI(JNIEnv *env, jclass type) {
    return getABI(env);
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1checkLicense(JNIEnv *env,
                                                                       jobject instance,
                                                                       jstring str_,
                                                                       jstring str2_) {
    const char *str = env->GetStringUTFChars(str_, 0);
    const char *str2 = env->GetStringUTFChars(str2_, 0);

    // TODO

    env->ReleaseStringUTFChars(str_, str);
    env->ReleaseStringUTFChars(str2_, str2);
    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_up_EngineManagerWrapper_native_1cancelSuarez(JNIEnv *env,
                                                                       jobject instance) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_AHLOHAClient_native_1sendErrorReport(JNIEnv *env, jclass type,
                                                               jobject obj) {

    // TODO

    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_AHLOHAClient_native_1ahlohaclientInit(JNIEnv *env, jclass type,
                                                                jstring str_) {
    const char *str = env->GetStringUTFChars(str_, 0);

    // TODO

    env->ReleaseStringUTFChars(str_, str);
    return 0;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_ahnlab_enginesdk_AHLOHAClient_native_1ahlohaclientDestroy(JNIEnv *env, jclass type) {

    // TODO

    return 0;
}

