package b2c.example.dto;

import b2c.example.domain.SuccessKilled;
import b2c.example.enums.SeckillStatEnum;

/**
 * Created by 菜小川 on 2017/10/23.
 */
public class SeckillExecution {
    private long seckillId;
    //执行秒杀结果状态
    private int state;
    //状态表示
    private String stateInfo;

    private SuccessKilled successKilled;
    //stateEnum代替state和stateInfo两个参数
    public SeckillExecution(long seckillId, SeckillStatEnum stateEnum,SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    public SeckillExecution(long seckillId, SeckillStatEnum stateEnum) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successKilled=" + successKilled +
                '}';
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStatInfo() {
        return stateInfo;
    }

    public void setStatInfo(String statInfo) {
        this.stateInfo = statInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}
