package com.github.aspatsalyuk.dictionary;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorDescription {

    TRACK_NOT_FOUND(404, 1, "Track not found");

    private final int statusCode;
    private final int errorCode;
    private final String description;
}
