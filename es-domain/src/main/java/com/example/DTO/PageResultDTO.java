package com.example.DTO;

/**
 *  带分页的 数据传输对象
 * @param <T>
 */
public class PageResultDTO<T> extends ResultDTO<T> {

    private int totalCount;  // 总数目

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public static <T> PageResultDTO success(T data, int totalCount) {
        PageResultDTO<T> resultDTO = new PageResultDTO();
        resultDTO.setSuccess(true);
        resultDTO.setData(data);
        resultDTO.setTotalCount(totalCount);
        return resultDTO;
    }
}
