package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    //This method displays the comments that are available for the image
    @RequestMapping(value = "/image/{id}/{title}/comments", method = RequestMethod.POST)
    public String addNewComment(@PathVariable("id") Integer imageId,@RequestParam(value = "comment") String text, HttpSession session) {

        User currentUser = (User) session.getAttribute("loggeduser");
        Image image = imageService.getImage(imageId);
        Comment newComment = new Comment();

        newComment.setUser(currentUser);
        newComment.setImage(image);
        newComment.setText(text);
        newComment.setCreatedDate(new Date());
        commentService.addNewComment(newComment);
        return "redirect:/images/"+image.getId()+"/"+ image.getTitle();
    }

}
