package repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.MinistryEntity;
import repository.IGenericRepository;
import util.DatetimeUtils;
import util.ExceptionUtils;

public class MinistryRepository extends BaseRepository implements IGenericRepository<MinistryEntity, Long> {
	private static Logger logger = LoggerFactory.getLogger(StudentRepository.class);

	@Override
	public List<MinistryEntity> findAll() {
		List<MinistryEntity> ministries = new ArrayList<>();

		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT m.*, ");
			builder.append("c.id, c.name as c_name ");
			builder.append("FROM Ministry m ");
			builder.append("LEFT JOIN Classroom c ON m.id = c.ministry_id ");
			builder.append("WHERE m.role = 0 ");
			rs = stmt.executeQuery(builder.toString());

			MinistryEntity ministry = null;
			while (rs.next()) {
				ministry = new MinistryEntity();
				ministry.setId(rs.getLong("id"));
				ministry.setFirstName(rs.getString("first_name"));
				ministry.setLastName(rs.getString("last_name"));
				ministry.setEmail(rs.getString("email"));
				ministry.setPassword(rs.getString("password"));
				ministry.setPhone(rs.getString("phone"));
				ministry.setCreatedAt(DatetimeUtils.convertDateToString(rs.getString("created_at"),
						DatetimeUtils.CREATED_AT_PATTERN));
				ministry.setCreatedBy(rs.getString("created_by"));

				Date dateModifiedAt = null;
				if (rs.getString("modified_at") != null) {
					dateModifiedAt = DatetimeUtils.convertDateToString(rs.getString("modified_at"),
							DatetimeUtils.CREATED_AT_PATTERN);
				}
				ministry.setModifiedAt(dateModifiedAt);

				ministry.setModifiedBy(rs.getString("modified_by"));
				ministry.setClassroomName(rs.getString("c_name"));
				ministry.setRole(rs.getLong("role"));
				ministries.add(ministry);
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
				logger.error("findAll() method - finally", e);
			}
		}

		return ministries;
	}

	@Override
	public MinistryEntity findById(Long value) {
		MinistryEntity ministry = new MinistryEntity();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT m.*, ");
			builder.append("c.id, c.name as c_name, ");
			builder.append("FROM Ministry m ");
			builder.append("INNER JOIN Classroom c ON m.id = c.ministry_id ");
			builder.append("WHERE m.id = ? ");

			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setLong(1, value);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ministry = new MinistryEntity();
				ministry.setId(rs.getLong("id"));
				ministry.setFirstName(rs.getString("first_name"));
				ministry.setLastName(rs.getString("last_name"));
				ministry.setEmail(rs.getString("email"));
				ministry.setPassword(rs.getString("password"));
				ministry.setPhone(rs.getString("phone"));
				ministry.setCreatedAt(DatetimeUtils.convertDateToString(rs.getString("created_at"),
						DatetimeUtils.CREATED_AT_PATTERN));
				ministry.setCreatedBy(rs.getString("created_by"));

				Date dateModifiedAt = null;
				if (rs.getString("modified_at") != null) {
					dateModifiedAt = DatetimeUtils.convertDateToString(rs.getString("modified_at"),
							DatetimeUtils.CREATED_AT_PATTERN);
				}
				ministry.setModifiedAt(dateModifiedAt);

				ministry.setModifiedBy(rs.getString("modified_by"));
				ministry.setRole(rs.getLong("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("findById() method ", e);
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
				logger.error("findById() method - finally ", e);
			}
		}

		return ministry;
	}

	public MinistryEntity findByEmail(String email) {
		MinistryEntity ministry = new MinistryEntity();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT * FROM Ministry ");
			builder.append("WHERE email = ? ");

			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ministry = new MinistryEntity();
				ministry.setId(rs.getLong("id"));
				ministry.setFirstName(rs.getString("first_name"));
				ministry.setLastName(rs.getString("last_name"));
				ministry.setEmail(rs.getString("email"));
				ministry.setPassword(rs.getString("password"));
				ministry.setPhone(rs.getString("phone"));
				ministry.setCreatedAt(DatetimeUtils.convertDateToString(rs.getString("created_at"),
						DatetimeUtils.CREATED_AT_PATTERN));
				ministry.setCreatedBy(rs.getString("created_by"));

				Date dateModifiedAt = null;
				if (rs.getString("modified_at") != null) {
					dateModifiedAt = DatetimeUtils.convertDateToString(rs.getString("modified_at"),
							DatetimeUtils.CREATED_AT_PATTERN);
				}
				ministry.setModifiedAt(dateModifiedAt);
				ministry.setModifiedBy(rs.getString("modified_by"));
				ministry.setRole(rs.getLong("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("findByEmail() method ", e);
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
				logger.error("findByEmail() method - finally ", e);
			}
		}

		return ministry;
	}
	
	@Override
	public int insert(MinistryEntity entity) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int rowAffected = -1;

		try {
			StringBuilder builder = new StringBuilder("INSERT INTO Ministry ");
			builder.append("(first_name, last_name, email, password, phone, created_at, created_by, role)");
			builder.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?) ");

			pstmt = conn.prepareStatement(builder.toString());

			pstmt.setString(1, entity.getFirstName());
			pstmt.setString(2, entity.getLastName());
			pstmt.setString(3, entity.getEmail());
			pstmt.setString(4, entity.getPassword());
			pstmt.setString(5, entity.getPhone());
			pstmt.setString(6,
					DatetimeUtils.convertDateToString(entity.getCreatedAt(), DatetimeUtils.CREATED_AT_PATTERN));
			pstmt.setString(7, entity.getCreatedBy());
			pstmt.setLong(8, 0L);

			rowAffected = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {

			}
		}

		return rowAffected;
	}

	@Override
	public int update(MinistryEntity entity) {
		Connection conn = getConnection();;
		PreparedStatement pstmt = null;
		int rowAffected = -1;

		try {
			StringBuilder builder = new StringBuilder();
			builder.append("UPDATE Ministry SET ");
			builder.append("first_name = ?, ");  // 1
			builder.append("last_name = ?, ");  // 2
			builder.append("email = ?, "); // 3
			builder.append("password = ?, ");  // 4
			builder.append("phone = ?, ");  // 5
			builder.append("modified_at = ?, "); // 6
			builder.append("modified_by = ? ");  // 7
			builder.append("WHERE id = ? "); // 8

			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setString(1, entity.getFirstName());
			pstmt.setString(2, entity.getLastName());
			pstmt.setString(3, entity.getEmail());
			pstmt.setString(4, entity.getPassword());
			pstmt.setString(5, entity.getPhone());
			pstmt.setString(6,
					DatetimeUtils.convertDateToString(entity.getModifiedAt(), DatetimeUtils.CREATED_AT_PATTERN));
			pstmt.setString(7, entity.getModifiedBy());
			pstmt.setLong(8, entity.getId());

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
	public int delete(Long value) throws ExceptionUtils {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int rowAffected = -1;

		try {
			StringBuilder builder = new StringBuilder();
			builder.append("DELETE FROM Ministry ");
			builder.append("WHERE id = ? ");

			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setLong(1, value);
			rowAffected = pstmt.executeUpdate();
			
		} catch (SQLIntegrityConstraintViolationException e) {
			logger.warn("delete() - method delete() - method Giáo vụ đang quản lý lớp học, nên không thể xóa");
			throw new ExceptionUtils("Giáo vụ đang quản lý lớp học, nên không thể xóa"); 
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("delete() - method", e);
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

	public boolean isMinistryExist(String email) {
		Connection conn = getConnection();;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean isExist = false;

		try {
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT * ");
			builder.append("FROM Ministry ");
			builder.append("WHERE email = ? ");

			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				isExist = true;
			}

		} catch (SQLException e) {
			logger.error("isMinistryExist() method", e);
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
				logger.error("isMinistryExist() method - finnaly", e);
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
					logger.error("isMinistryExist() method - finnaly", e);
				}
			}
		}

		return isExist;
	}
}
