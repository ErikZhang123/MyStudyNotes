package com.hospital.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

//lombok 插件，自动生成set，get方法
@Data
public class hospital_user {
//    MP策略来自动填充id，其中type有不同的策略，
    @TableId(type= IdType.ASSIGN_ID) // 生成19位id，使用了雪花算法
    /**ASSIGN_UUID
     * AUTO：自动填充
     * INPUT: 要手动用set方法设置
     * NONE*/

    private Long userId;
    private String userName;
    private Integer userAge;
    private String userEmail;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime; // 表中会转换为 create_Time
    //如果仅仅写insert，在
    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @Version
    private Integer version;
//    逻辑删除标志

    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;
}
