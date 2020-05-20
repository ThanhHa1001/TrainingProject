package repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.ClassroomEntity;
import repository.IGenericRepository;
import util.DatetimeUtils;

public class ClassroomRepository extends BaseRepository implements IGenericRepository<ClassroomEntity, Long> {
	private static final Logger logger = LoggerFactory.getLogger(ClassroomRepository.class);

	@Override
	public List<ClassroomEntity> findAll() {
		List<ClassroomEntity> classrooms = new ArrayList<>();

		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT c.*, CONCAT(m.first_name, ' ', m.last_name) as ministry_name ");
			builder.append("FROM classroom c ");
			builder.append("INNER JOIN ministry m ");
			builder.append("ON c.ministry_id = m.id");

			logger.debug("findAll() sql = " + builder.toString());
			rs = stmt.executeQuery(builder.toString());

			while (rs.next()) {
				ClassroomEntity classroomEntity = new ClassroomEntity();
				classroomEntity.setId(rs.getLong("id"));
				classroomEntity.setName(rs.getString("name"));
				classroomEntity.setMinistryId(rs.getLong("ministry_id"));
				classroomEntity.setMinistryName(rs.getString("ministry_name"));
				classroomEntity.setCreatedAt(rs.getDate("created_at"));
				classroomEntity.setCreatedBy(rs.getString("created_by"));
				classroomEntity.setModifiedAt(rs.getDate("modified_at"));
				classroomEntity.setModifiedBy(rs.getString("modified_by"));
				classrooms.add(classroomEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("findAll() method", e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("findAll() method - finnaly", e);
			}
		}
		return classrooms;
	}

	@Override
	public ClassroomEntity findById(Long value) {
		ClassroomEntity classroomEntity = new ClassroomEntity();

		Connection conn = getConnection();;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT c.*, CONCAT(m.first_name, ' ', m.last_name) as ministry_name ");
			builder.append("FROM classroom c ");
			builder.append("INNER JOIN ministry m ");
			builder.append("ON c.ministry_id = m.id ");
			builder.append("WHERE c.id = ? ");

			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setLong(1, value);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				classroomEntity.setId(rs.getLong("id"));
				classroomEntity.setName(rs.getString("name"));
				classroomEntity.setMinistryId(rs.getLong("ministry_id"));
				classroomEntity.setMinistryName(rs.getString("ministry_name"));
				classroomEntity.setCreatedAt(rs.getDate("created_at"));
				classroomEntity.setCreatedBy(rs.getString("created_by"));
				classroomEntity.setModifiedAt(rs.getDate("modified_at"));
				classroomEntity.setModifiedBy(rs.getString("modified_by"));
			}

		} catch (SQLException e) {
			logger.error("findById() method", e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("findById() method - finnaly", e);
			} finally {
				try {
					if (pstmt != null) {
						pstmt.close();
					}

					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					logger.error("findById() method - finnaly", e);
				}
			}
		}

		return classroomEntity;
	}

	
	@Override
	public int insert(ClassroomEntity entity) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int rowAffected = -1;

		try {
			StringBuilder builder = new StringBuilder();
			builder.append("INSERT INTO Classroom (name, ministry_id, created_at, created_by) ");
			builder.append("VALUES (?, ?, ?, ?)");
			
			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setString(1, entity.getName());
			pstmt.setLong(2, entity.getMinistryId());
			pstmt.setString(3, DatetimeUtils.convertDateToString(entity.getCreatedAt(), DatetimeUtils.CREATED_AT_PATTERN));
			pstmt.setString(4, entity.getCreatedBy());

			rowAffected = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("insert() method ", e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("insert() method - finnaly", e);
			}
		}

		return rowAffected;
	}

	@Override
	public int update(ClassroomEntity entity) {
		Connection conn = getConnection();;
		PreparedStatement pstmt = null;
		int rowAffected = -1;

		try {
			StringBuilder builder = new StringBuilder();
			builder.append("UPDATE Classroom SET ");
			builder.append("name = ?, ");
			builder.append("ministry_id = ?, ");
			builder.append("modified_at = ?, ");
			builder.append("modified_by = ? ");
			builder.append("WHERE id = ? ");

			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setString(1, entity.getName());
			pstmt.setLong(2, entity.getMinistryId());
			pstmt.setString(3,
					DatetimeUtils.convertDateToString(entity.getCreatedAt(), DatetimeUtils.CREATED_AT_PATTERN));
			pstmt.setString(4, entity.getModifiedBy());
			pstmt.setLong(5, entity.getId());

			rowAffected = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("update() method");
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("update() method - finnaly", e);
			}
		}

		return rowAffected;
	}

	@Override
	public int delete(Long value) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int rowAffected = -1;
		
		try {
			StringBuilder builder = new StringBuilder();
			builder.append("DELETE FROM Classroom ");
			builder.append("WHERE id = ? ");
			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setLong(1, value);
			rowAffected = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("delete() method");
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("delete() method - finnaly", e);
			}
		}

		return rowAffected;
	}
	
	
	public boolean isClassroomExist(String value) {
		Connection conn = getConnection();;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean isExist = false;

		try {
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT * ");
			builder.append("FROM classroom ");
			builder.append("WHERE name = ? ");

			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setString(1, value);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				isExist = true;
			}

		} catch (SQLException e) {
			logger.error("isClassroomExist() method", e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("isClassroomExist() method - finnaly", e);
			} finally {
				try {
					if (pstmt != null) {
						pstmt.close();
					}

					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					logger.error("isClassroomExist() method - finnaly", e);
				}
			}
		}

		return isExist;
	}
	
	public List<ClassroomEntity> findByMinistryId(Long value) {
		List<ClassroomEntity> classrooms = new ArrayList<>();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT c.*, CONCAT(m.first_name, ' ', m.last_name) as ministry_name ");
			builder.append("FROM classroom c ");
			builder.append("INNER JOIN ministry m ");
			builder.append("ON c.ministry_id = m.id ");
			builder.append("WHERE c.ministry_id = ? ");

			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setLong(1, value);
			logger.debug("findByMinistryId() sql = " + builder.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ClassroomEntity classroomEntity = new ClassroomEntity();
				classroomEntity.setId(rs.getLong("id"));
				classroomEntity.setName(rs.getString("name"));
				classroomEntity.setMinistryId(rs.getLong("ministry_id"));
				classroomEntity.setMinistryName(rs.getString("ministry_name"));
				classroomEntity.setCreatedAt(rs.getDate("created_at"));
				classroomEntity.setCreatedBy(rs.getString("created_by"));
				classroomEntity.setModifiedAt(rs.getDate("modified_at"));
				classroomEntity.setModifiedBy(rs.getString("modified_by"));
				classrooms.add(classroomEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("findByMinistryId() method", e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("findByMinistryId() method - finnaly", e);
			}
		}
		return classrooms;
	}
}