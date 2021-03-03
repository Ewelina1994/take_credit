package pl.klobut.take_credit.mapper;

import java.util.List;

public interface EntityMapper<TDto, TEntity> {
	public TEntity toEntity(TDto dto);

	public TDto toDto(TEntity entity);

	public List<TEntity> toEntityList(List<TDto> dtoList);

	public List<TDto> toDtoList(List<TEntity> entityList);
}
