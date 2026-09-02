package com.mjchoi.memo_api.memo;

import java.time.LocalDateTime;

public record Memo(Long id, String title, String content, LocalDateTime createdAt) {
}
