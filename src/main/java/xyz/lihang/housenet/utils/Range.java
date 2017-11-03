package xyz.lihang.housenet.utils;

/**
 * Created by Administrator on 2017/7/3.
 */
public final class Range  {
    //面积
    private Integer startFloorage ;
    private Integer endFloorage;

    //类型Id
    private Integer typeId;

    //
    private Integer startPrice;
    private Integer endPrice;


    public Integer getStartFloorage() {
        return startFloorage;
    }

    public void setStartFloorage(Integer startFloorage) {
        this.startFloorage = startFloorage;
    }

    public Integer getEndFloorage() {
        return endFloorage;
    }

    public void setEndFloorage(Integer endFloorage) {
        this.endFloorage = endFloorage;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Integer endPrice) {
        this.endPrice = endPrice;
    }
}
