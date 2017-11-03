package xyz.lihang.housenet.utils;

/**
 * Created by Administrator on 2017/11/2.
 */
public class Page {
    public final static String PageModelStr = "PageModelStr";

    // 1.每页显示数量(everyPage)
    private int everyPage;
    // 2.总记录数(totalCount)
    private int totalCount;
    // 3.总页数(totalPage)
    private int totalPage;
    // 4.当前页(currentPage)
    private int currentPage;
    // 5.起始点(beginIndex)
    private int beginIndex;
    // 6.是否有上一页(hasPrePage)
    private boolean hasPrePage;
    // 7.是否有下一页(hasNextPage)
    private boolean hasNextPage;
    //页面传过来的参数
    private int p = 0;

    public Page(int everyPage, int totalCount, int totalPage, int currentPage,
                int beginIndex, boolean hasPrePage, boolean hasNextPage) {
        this.everyPage = everyPage;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.beginIndex = beginIndex;
        this.hasPrePage = hasPrePage;
        this.hasNextPage = hasNextPage;
    }

    //构造函数，默认
    public Page(){}

    //构造方法，对所有属性进行设置


    public int getEveryPage() {
        return everyPage;
    }

    public void setEveryPage(int everyPage) {
        this.everyPage = everyPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    public boolean isHasPrePage() {
        return hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "Page [everyPage=" + everyPage + ", totalCount="
                + totalCount + ", totalPage=" + totalPage
                + ", currentPage=" + currentPage + ", beginIndex="
                + beginIndex + ", hasPrePage=" + hasPrePage
                + ", hasNextPage=" + hasNextPage + "]";
    }


}
