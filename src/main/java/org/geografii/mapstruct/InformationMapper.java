package org.geografii.mapstruct;

import org.geografii.dto.InformationModelDTO;
import org.geografii.model.InformationModel;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface InformationMapper {
    InformationModel informationDTOToInformationModel(InformationModelDTO informationModelDTO);

    InformationModelDTO informationModelToInformationDTO(InformationModel informationModel);

    Set<InformationModel> informationDTOSetToInformationModelSet(Set<InformationModelDTO> informationModelDTO);

    Set<InformationModelDTO> informationModelSetToInformationDTOSet(Set<InformationModel> informationModel);
}
