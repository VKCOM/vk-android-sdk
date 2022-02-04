# Used for IPC and must not be obfuscated, otherwise SilentAuthInfo won't be able to parse correctly
-keepnames class com.vk.dto.common.id.UserId { *; }