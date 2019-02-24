package io.khasang.bend.service;

import java.util.List;

public interface QueriesTableColors {
    String getInsertColorStatus(Color color);

    String getSelectColorStatus(long color_id);

    List<Color> getSelectAllColorsStatus();

    String getUpdateColorsStatus(long color_id);

    String getDeleteColorStatus(Color color);
}
