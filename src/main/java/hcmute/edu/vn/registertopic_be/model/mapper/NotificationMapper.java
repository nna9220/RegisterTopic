package hcmute.edu.vn.registertopic_be.model.mapper;

import hcmute.edu.vn.registertopic_be.model.entity.Notification;
import hcmute.edu.vn.registertopic_be.model.request.NotificationRequest;
import hcmute.edu.vn.registertopic_be.model.response.NotificationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    @Mapping(source = "notification.notificationId", target = "notificationId")
    @Mapping(source = "notification.content", target = "content")
    @Mapping(source = "notification.title", target = "title")
    @Mapping(source = "notification.dateSubmit", target = "dateSubmit")
    NotificationResponse toResponse(Notification notification);

    List<NotificationResponse> toNotificationListDTO(List<Notification> notifications);

    Notification toEntity(NotificationRequest notificationRequest);
}
