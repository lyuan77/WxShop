/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://talelin.com
 * @免费专栏 $ http://course.talelin.com
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2019-08-05 05:37
 */
package com.lin.missyou.service;

import com.lin.missyou.core.enumeration.CouponStatus;
import com.lin.missyou.exception.http.NotFoundException;
import com.lin.missyou.exception.http.ParameterException;
import com.lin.missyou.model.Activity;
import com.lin.missyou.model.Coupon;
import com.lin.missyou.model.User;
import com.lin.missyou.model.UserCoupon;
import com.lin.missyou.repository.ActivityRepository;
import com.lin.missyou.repository.CouponRepository;
import com.lin.missyou.repository.UserCouponRepository;
import com.lin.missyou.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserCouponRepository userCouponRepository;

    public List<Coupon> getByCategory(Long cid) {
        Date now = new Date();
        return couponRepository.findByCategory(cid, now);
    }

    public List<Coupon> getWholeStoreCoupons() {
        Date now = new Date();
        return couponRepository.findByWholeStore(true, now);
    }

    public List<Coupon> getMyAvailableCoupons(Long uid) {
        Date now = new Date();
        return this.couponRepository.findMyAvailable(uid, now);
    }

    public List<Coupon> getMyUsedCoupons(Long uid) {
        Date now = new Date();
        return this.couponRepository.findMyUsed(uid, now);
    }

    public List<Coupon> getMyExpiredCoupons(Long uid) {
        Date now = new Date();
        return this.couponRepository.findMyExpired(uid, now);
    }

    public void collectOneCoupon(Long uid, Long couponId){
        this.couponRepository
                .findById(couponId)
                .orElseThrow(() -> new NotFoundException(40003));

        Activity activity = this.activityRepository
                .findByCouponListId(couponId)
                .orElseThrow(() -> new NotFoundException(40010));

        Date now = new Date();
        Boolean isIn = CommonUtil.isInTimeLine(now, activity.getStartTime(), activity.getEndTime());
        if(!isIn){
            throw new ParameterException(40005);
        }

        this.userCouponRepository
                .findFirstByUserIdAndCouponId(uid, couponId)
                .ifPresent((uc)-> {throw new ParameterException(40006);});

        UserCoupon userCouponNew = UserCoupon.builder()
                .userId(uid)
                .couponId(couponId)
                .status(CouponStatus.AVAILABLE.getValue())
                .createTime(now)
                .build();
        userCouponRepository.save(userCouponNew);
    }






















//    public List<Coupon> getMyAvailableCoupons(Long uid) {
//        Date now = new Date();
//        return couponRepository.findMyAvailable(uid, now);
//    }
//
//    public List<Coupon> getMyUsedCoupons(Long uid) {
//        Date now = new Date();
//        return couponRepository.findMyUsed(uid, now);
//    }
//
//    public List<Coupon> getMyExpiredCoupons(Long uid) {
//        Date now = new Date();
//        return couponRepository.findUserExpired(uid, now);
//    }
//

//    public void writeOff(Long couponId) {
//
//    }

//    @Transactional
//    public void collectOneCoupon(Long uid, Long couponId) {
//        Date now = new Date();
//        // 很好的Optional案例
//        this.couponRepository
//                .findById(couponId)
//                .orElseThrow(()->new NotFound(40003));
//        Optional<Activity> optionalActivity = this.activityRepository.findByCouponListId(couponId);
//        Activity activity = optionalActivity
//                .orElseThrow(()->new NotFound(40010));
//
//        // TODO：有问题，应该判断活动是否过期
//        Boolean isIn = CommonUtil.isInTimeLine(now, activity.getStartTime(), activity.getEndTime());
//        if (!isIn) {
//            throw new ParameterException(40005);
//        }
//        UserCoupon userCoupon = userCouponRepository.findFirstByUserIdAndCouponId(uid, couponId);
//        if (userCoupon != null) {
//            throw new ParameterException(40006);
//        }
//        UserCoupon userCouponNew = UserCoupon.builder()
//                .couponId(couponId)
//                .userId(uid)
//                .status(CouponStatus.AVAILABLE.value())
//                .createTime(now)
//                .build();
//        userCouponRepository.save(userCouponNew);
//    }

//    public Coupon getCoupon(Long id) {
//        return couponRepository.getOne(id);
//    }


//    public List<Coupon> getListByActivityId(Long aid) {
//        return null;
////        return couponRepository.findAllByActivityListId(aid);
//    }

}
