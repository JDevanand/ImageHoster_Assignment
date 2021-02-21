package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    //Call the getComments() method in the Repository passing the imageId and obtain a List of all the comments from the database
    public List<Comment> getComments(Integer imageId) {
        return commentRepository.getComments(imageId);
    }

    //The method calls the addComment() method in the Repository and passes the commen to be persisted in the database
    public void addNewComment(Comment comment){
        commentRepository.addComment(comment);
    }

}
