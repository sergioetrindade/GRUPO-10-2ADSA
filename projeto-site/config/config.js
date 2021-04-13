module.exports = {
  production: {
    username: 'logicagora',
    password: '#Gf45455505840',
    database: 'bdProjeto1sem',
    host: 'bdprojeto1sem.database.windows.net',
    dialect: 'mssql',
    xuse_env_variable: 'DATABASE_URL',
    dialectOptions: {
      options: {
        encrypt: true
      }
    },
    pool: { 
      max: 5,
      min: 1,
      acquire: 5000,
      idle: 30000,
      connectTimeout: 5000
    }
  }
};
 
