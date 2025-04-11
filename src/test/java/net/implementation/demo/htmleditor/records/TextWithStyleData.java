package net.implementation.demo.htmleditor.records;

import net.implementation.demo.htmleditor.enums.TextStyle;

import java.util.List;

public record TextWithStyleData(
    String TEXT,
    List<TextStyle> STYLE_LIST
) {}
