package com.qiuhn.gudu.db;

import com.qiuhn.gudu.domain.ForumTopic;
import com.qiuhn.gudu.pojo.ForumTopicPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuhn on 2015/11/25.
 */
public class ForumDaoHelper extends BaseDaoHelper {


    public static void saveOrUpdateTopic(List<ForumTopicPojo> list) {
        if (list == null) {
            return;
        }
        List<ForumTopic> forumTopics = new ArrayList<>(list.size());
        for (ForumTopicPojo each:list){
            ForumTopic forumTopic = new ForumTopic(
                    each.getId(), each.getTitle(), each.getContent(),
                    each.getImgs(),each.getSchoolId(), each.getLikeCount(), each.getReplyCount(),
                    each.getUserId(), each.getCreateDate(), each.getLatestUpdateTime(),
                    each.getStatus(), each.getMeLike());
            forumTopics.add(forumTopic);
        }
        getForumTopicDao().insertOrReplaceInTx(forumTopics);
    }

    public static List<ForumTopicPojo> queryTopicList() {

        return null;
    }
}
