package com.souhardya.minigit.repository;

import com.souhardya.minigit.domain.Repository;

public record InitializationResult(
        Repository repository,
        InitializationStatus status
) {
}