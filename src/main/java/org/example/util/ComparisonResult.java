package org.example.util;

import java.util.List;

public record ComparisonResult(
        List<String> disappearedPages,
        List<String> newPages,
        List<String> updatedPages
) {
}
