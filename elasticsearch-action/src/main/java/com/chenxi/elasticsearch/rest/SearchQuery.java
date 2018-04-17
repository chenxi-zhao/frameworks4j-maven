package com.chenxi.elasticsearch.rest;

import com.chenxi.elasticsearch.rest.query.enums.SortOrder;

import java.io.Serializable;
import java.util.Date;

/**
 * 搜索查询对象
 */
public class SearchQuery implements Serializable {

    public enum SEARCH_PROP_NAME_ENUM {
        IMG_NAME(0, "imgName"), PRODUCT_NAME(1, "productName");
        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        SEARCH_PROP_NAME_ENUM(int code, String value) {
            this.code = code;
            this.value = value;
        }
    }

    private static final long serialVersionUID = -689392756214805571L;
    // 用户pin
    private String userId;
    // 索引ID
    private String id;
    // 分类ID
    private Long cateId;
    // 搜索关键字属性名
    private SEARCH_PROP_NAME_ENUM propName = SEARCH_PROP_NAME_ENUM.IMG_NAME;
    // 搜索关键字
    private String text;
    // 图片宽度开始
    private Integer widthBegin;
    // 图片宽度结束
    private Integer widthEnd;
    // 图片高度开始
    private Integer heightBegin;
    // 图片高度结束
    private Integer heightend;
    // 上传开始时间
    private Date begin;
    // 上传结束时间
    private Date end;
    // 排序字段名
    private String sortProName;
    // 排序方式
    private SortOrder order = SortOrder.DESC;
    // 分页开始条数
    private int startRow = 0;
    // 分页查询最大条数
    private int maxRows = 50;
    // 是否分词 。 false表示不分词，true表示分词
    private boolean isSepWord = true;

    // 是否被引用 0-未引用，1-已引用 null-不区分
    private Integer useFlag;
    private String imageName;

    // 类型过滤，填写type时过滤，默认不过滤
    private String imageType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public SEARCH_PROP_NAME_ENUM getPropName() {
        return propName;
    }

    public void setPropName(SEARCH_PROP_NAME_ENUM propName) {
        this.propName = propName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getWidthBegin() {
        return widthBegin;
    }

    public void setWidthBegin(Integer widthBegin) {
        this.widthBegin = widthBegin;
    }

    public Integer getWidthEnd() {
        return widthEnd;
    }

    public void setWidthEnd(Integer widthEnd) {
        this.widthEnd = widthEnd;
    }

    public Integer getHeightBegin() {
        return heightBegin;
    }

    public void setHeightBegin(Integer heightBegin) {
        this.heightBegin = heightBegin;
    }

    public Integer getHeightend() {
        return heightend;
    }

    public void setHeightend(Integer heightend) {
        this.heightend = heightend;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getSortProName() {
        return sortProName;
    }

    public void setSortProName(String sortProName) {
        this.sortProName = sortProName;
    }

    public SortOrder getOrder() {
        return order;
    }

    public void setOrder(SortOrder order) {
        this.order = order;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getMaxRows() {
        return maxRows;
    }

    public void setMaxRows(int maxRows) {
        this.maxRows = maxRows;
    }

    public boolean isSepWord() {
        return isSepWord;
    }

    public void setSepWord(boolean sepWord) {
        isSepWord = sepWord;
    }

    public Integer getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Integer useFlag) {
        this.useFlag = useFlag;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}
