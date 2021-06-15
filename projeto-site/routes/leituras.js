var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var registro = require('../models').registro;

/* Recuperar as últimas N leituras */
router.get('/ultimas/:idRegistro', function(req, res, next) {
	
	// quantas são as últimas leituras que quer? 8 está bom?
	const idRegistro = req.params.idRegistro;
	const limite_linhas = 7;

	console.log(`Recuperando as ultimas ${limite_linhas} leituras`);
	
	const instrucaoSql = `select top ${limite_linhas}
							cpu1,
							disco,
							memoria,
							dataHora,
							FORMAT(dataHora,'HH:mm:ss') as momento_grafico
							from registro where idMaquina = 1`;


	sequelize.query(instrucaoSql, {
		model: registro,
		mapToModel: true
	  })
	  .then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado);
	  }).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
	  });
});


// tempo real (último valor de cada leitura)
router.get('/tempo-real', function (req, res, next) {
	
	console.log(`Recuperando a ultima leitura`);

	const instrucaoSql = `select top 1
	cpu1,
	disco,
	memoria,
	dataHora,
	FORMAT(dataHora,'HH:mm:ss') as momento_grafico
	from registro order by idRegistro desc`;

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
		.then(resultado => {
			res.json(resultado[0]);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
  
});

module.exports = router;