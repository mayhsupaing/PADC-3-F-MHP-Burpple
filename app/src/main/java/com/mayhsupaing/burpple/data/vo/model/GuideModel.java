package com.mayhsupaing.burpple.data.vo.model;

import com.mayhsupaing.burpple.network.GuideOKHttpDataAgent;
import com.mayhsupaing.burpple.network.GuideRetrofitDataAgent;
import com.mayhsupaing.burpple.network.PromotionDataAgent;
import com.mayhsupaing.burpple.network.PromotionRetrofitDataAgent;

/**
 * Created by Lenovo on 1/12/2018.
 */

public class GuideModel {

    private PromotionDataAgent sPromotionDataAgent;

    private static GuideModel sObjInstance;

    private GuideModel(){

        //sPromotionDataAgent= GuideOKHttpDataAgent.getsObjInstance();
        sPromotionDataAgent= GuideRetrofitDataAgent.getsObjInstance();
    }

    public static GuideModel getsObjInstance(){
        if(sObjInstance==null)
        {
            sObjInstance=new GuideModel();
        }
        return sObjInstance;
    }

    public void LoadPromotion(){
        sPromotionDataAgent.loadPromotion();
    }
}
