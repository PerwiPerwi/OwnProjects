package controllers;

import play.Play;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import views.html.editProfile.updateUserProfilePicture;
import models.User;

import java.io.File;

/**
 * Created by RENT on 2016-06-16.
 */
public class PictureUploadController extends Controller{

    @Security.Authenticated(SeciurityController.class)
    public Result updatePictureForm(){
        User user = SeciurityController.getUser();
        if(user == null){
            return redirect(routes.LoginAndLogoutController.loginForm());
        }
        return ok(updateUserProfilePicture.render(user));
    }
    @Security.Authenticated(SeciurityController.class)
    public Result uploadUserPicture() {
        Http.MultipartFormData<File> body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart<File> picture = body.getFile("picture");
        if (picture != null) {
            User user = SeciurityController.getUser();
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File file = picture.getFile();

            File root = Play.application().path();
            String myUploadPath = Play.application().configuration().getString("myUploadPath");
            String path = root.getPath() + myUploadPath;
            file.renameTo(new File(path, fileName));
            user.setProfilPicture(fileName);
            return ok();
        } else {
            flash("error", "Missing file");
            return badRequest();
        }
    }
}
