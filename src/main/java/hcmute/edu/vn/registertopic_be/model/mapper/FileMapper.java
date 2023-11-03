package hcmute.edu.vn.registertopic_be.model.mapper;

import hcmute.edu.vn.registertopic_be.model.entity.File;
import hcmute.edu.vn.registertopic_be.model.request.FileRequest;
import hcmute.edu.vn.registertopic_be.model.response.FileResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FileMapper {
    @Mapping(source = "file.fileId", target = "fileId")
    FileResponse toResponse(File file);

    List<FileResponse> toCommentListDTO(List<File> files);

    File toEntity(FileRequest fileRequest);
}
