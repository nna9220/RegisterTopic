package hcmute.edu.vn.registertopic_be.model.mapper;

import hcmute.edu.vn.registertopic_be.model.entity.Comment;
import hcmute.edu.vn.registertopic_be.model.request.CommentRequest;
import hcmute.edu.vn.registertopic_be.model.response.CommentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(source = "comment.commentId", target = "commentId")
    @Mapping(source = "comment.content", target = "content")
    @Mapping(source = "comment.dateSubmit", target = "dateSubmit")
    CommentResponse toResponse(Comment comment);
    List<CommentResponse> toCommentListDTO(List<Comment> comments);
    Comment toEntity(CommentRequest commentRequest);
}
