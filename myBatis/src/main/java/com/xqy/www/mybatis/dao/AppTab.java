package com.xqy.www.mybatis.dao;

import javax.persistence.*;

@Table(name = "app_tab")
public class AppTab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_name")
    private String cName;

    @Column(name = "c_tab_id")
    private String cTabId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return c_name
     */
    public String getcName() {
        return cName;
    }

    /**
     * @param cName
     */
    public void setcName(String cName) {
        this.cName = cName;
    }

    /**
     * @return c_tab_id
     */
    public String getcTabId() {
        return cTabId;
    }

    /**
     * @param cTabId
     */
    public void setcTabId(String cTabId) {
        this.cTabId = cTabId;
    }
}