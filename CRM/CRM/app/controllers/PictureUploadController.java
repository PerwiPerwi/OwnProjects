package controllers;

import models.User;
import play.Play;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import services.UserService;

import java.io.File;

public class PictureUploadController extends Controller {

    @Security.Authenticated(SeciurityController.class)
    public Result updatePictureForm() {
        User user = SeciurityController.getUser();
        if (user == null) {
            return redirect(routes.LoginAndLogoutController.loginForm());
        }
        return ok(views.html.updateProfileByUser.updateProfilePicture.render(user));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result uploadUserPicture() {
        UserService userService = new UserService();
        Http.MultipartFormData<File> body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart<File> picture = body.getFile("picture");
        if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File file = picture.getFile();

            File root = Play.application().path();
            String myUploadPath = Play.application().configuration().getString("myUploadPath");
            String path = root.getPath() + myUploadPath;
            file.renameTo(new File(path, fileName));
            User userForUpdate = SeciurityController.getUser();
            userService.updateProfilePicture(userForUpdate, fileName);
            return redirect(routes.PictureUploadController.updatePictureForm());
        } else {
            return redirect(routes.EditUserProfileController.editUserProfileForm());
        }
    }

    @Security.Authenticated(SeciurityController.class)
    public Result deletePictureByUser() {
        UserService userService = new UserService();
        User userForUpdate = SeciurityController.getUser();
        userService.setDefaultProfilePicture(userForUpdate);
        return redirect(routes.PictureUploadController.updatePictureForm());
    }

    @Security.Authenticated(SeciurityController.class)
    public Result deletePictureByAdmin(long userId) {
        UserService userService = new UserService();
        User userForUpdate = userService.findById(userId);
        userService.setDefaultProfilePicture(userForUpdate);
        return redirect(routes.AdminPanelController.editUserByAdminForm(userForUpdate.getId()));
    }
}

