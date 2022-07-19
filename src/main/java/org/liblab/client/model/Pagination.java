package org.liblab.client.model;

import java.io.Serializable;

public class Pagination implements Serializable {
    private int total = 0;

    private int limit = 0;

    private int offset = 0;

    private int page = 0;

    private int pages = 0;

    public int getTotal() {
        return total;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public int getPage() {
        return page;
    }

    public int getPages() {
        return pages;
    }

}
