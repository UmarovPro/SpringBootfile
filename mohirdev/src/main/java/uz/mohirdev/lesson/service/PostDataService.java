package uz.mohirdev.lesson.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.mohirdev.lesson.entity.PostData;
import uz.mohirdev.lesson.model.Post;
import uz.mohirdev.lesson.repository.PostDataRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostDataService {
    private final PostDataRepository postDataRepository;

    public PostDataService(PostDataRepository postDataRepository) {
        this.postDataRepository = postDataRepository;
    }
    public PostData save(PostData postData){
        return postDataRepository.save(postData);
    }

    public List<PostData> saveAll(Post[] posts) {
        List<PostData> postDataList = new ArrayList<>();
        for (Post post : posts) {
            PostData postData = new PostData();
            postData.setPostId(post.getId());
            postData.setUserId(post.getUserId());
            postData.setTitle(post.getTitle());
            postData.setBody(post.getBody());
            postDataList.add(postData);
        }
        return postDataRepository.saveAll(postDataList);
        //        List<PostData> postDataList = posts
//                .stream()
//                .map(post -> {
//                    PostData postData = new PostData();
//                    postData.setPostId(post.getId());
//                    postData.setUserId(post.getUserId());
//                    postData.setTitle(post.getTitle());
//                    postData.setBody(post.getBody());
//                    return postData;
//                }).collect(Collectors.toList());


        //        List<PostData> postDataList1 = new ArrayList<>();
//        for (Post post:posts) {
//            PostData postData = new PostData();                Array orqali
//            postData.setPostId(post.getId());
//            postData.setUserId(post.getUserId());
//            postData.setTitle(post.getTitle());
//            postData.setBody(post.getBody());
//            postDataList1.add(postData);
//        }
    }

    @Transactional(readOnly = true)
    public Page<PostData> findAll(Pageable pageable){
        return postDataRepository.findAll(pageable);
    }
}
