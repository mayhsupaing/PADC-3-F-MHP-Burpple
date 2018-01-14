package com.mayhsupaing.burpple.events;

import com.mayhsupaing.burpple.data.vo.GuideVO;
import com.mayhsupaing.burpple.data.vo.PromotionVO;

import java.util.List;

/**
 * Created by Lenovo on 1/13/2018.
 */

public class LoadGuideEvent {

    private List<GuideVO> guideList;

    public LoadGuideEvent(List<GuideVO> guideList){
        this.guideList=guideList;
    }

    public List<GuideVO> getGuideList(){
        return guideList;
    }
}
