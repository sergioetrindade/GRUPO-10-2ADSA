/*===== EXPANDER MENU  =====*/
const showMenu = (toggleId, navbarId, bodyId) => {
  const toggle = document.getElementById(toggleId),
    navbar = document.getElementById(navbarId),
    bodypadding = document.getElementById(bodyId)

  if (toggle && navbar) {
    toggle.addEventListener('click', () => {
      navbar.classList.toggle('expander')

      bodypadding.classList.toggle('body-pd')
    })
  }
}
showMenu('nav-toggle', 'navbar', 'body-pd')

/*===== LINK ACTIVE  =====*/
const linkColor = document.querySelectorAll('.nav__link')
function colorLink() {
  linkColor.forEach(l => l.classList.remove('active'))
  this.classList.add('active')
}
linkColor.forEach(l => l.addEventListener('click', colorLink))


/*===== COLLAPSE MENU  =====*/
const linkCollapse = document.getElementsByClassName('collapse__link')
var i

for (i = 0; i < linkCollapse.length; i++) {
  linkCollapse[i].addEventListener('click', function () {
    const collapseMenu = this.nextElementSibling
    collapseMenu.classList.toggle('showCollapse')

    const rotate = collapseMenu.previousElementSibling
    rotate.classList.toggle('rotate')
  })
}

var context = document.getElementById("chart").getContext("2d");
context.canvas.width = 1000;
context.canvas.height = 300;

var configuration = {
  type: "line",
  data: {
    datasets: [
      {
        label: "CPU",
        type: "line",
        backgroundColor: ["#1111"],
        borderColor: ["#ff6347"],
      },
    ],
  },
  options: {
    legend: {
      labels: {
        fontColor: "white",
        fontSize: 16,
      },
    },

    scales: {
      xAxes: [
        {
          //type: 'value',
          distribution: "series",
          ticks: {
            fontColor: "white",
            beginAtZero: true,
            maxticksLimit: 5,
          },
        },
      ],
      yAxes: [
        {
          scaleLabel: {
            display: true,
            labelString: "USO %",
            fontColor: "white",
          },
          ticks: {
            fontColor: "white",
            beginAtZero: true,
            suggestedMin: 0,
            suggestedMax: 30,
          },
        },
      ],
    },
    animation: {
      duration: 0,
    },
  },
};

var chart = new Chart(context, configuration);

//Função para obter os dados de temperatura do server
//Seria mais interessante fazer isso com WebSocket, porém para fins academicos, os dados serão atualizados via HTTP

//Esse atributo dentro do contexto serve para saber qual foi o último índice processado, assim eliminado os outros elementos na
//hora de montar/atualizar o gráfico
this.lastIndexTemp = 0;
this.time = 0;

function get_data() {
  var http = new XMLHttpRequest();
  http.open("GET", "http://localhost:3000/api", false);
  http.send(null);

  var obj = JSON.parse(http.responseText);
  console.log(obj);
  if (obj.data.length == 0) {
    return;
  }

  var _lastIndexTemp = this.lastIndexTemp;
  this.lastIndexTemp = obj.data.length;
  listTemp = obj.data.slice(_lastIndexTemp);

  listTemp.forEach((data) => {
    //Máximo de 60 itens exibidos no gráfico
    if (
      chart.data.labels.length == 10 &&
      chart.data.datasets[0].data.length == 10
    ) {
      chart.data.labels.shift();
      chart.data.datasets[0].data.shift();
    }

    chart.data.labels.push(this.time++);
    chart.data.datasets[0].data.push(parseFloat(data));
    chart.update();
  });
}

get_data();

function sendTemperature() {
  var http = new XMLHttpRequest();
  http.open("POST", "http://localhost:3000/api/sendData", false);
  http.send(null);
}

setInterval(() => {
  sendTemperature();
  get_data();
}, 4000);

// MEMORIA
// ---------------------------------------

var context = document.getElementById("chart2").getContext("2d");
context.canvas.width = 1000;
context.canvas.height = 300;

var configuration = {
  type: "line",
  data: {
    datasets: [
      {
        label: "MEMORIA",
        type: "line",
        backgroundColor: ["#1111"],
        borderColor: ["#ff6347"],
      },
    ],
  },
  options: {
    legend: {
      labels: {
        fontColor: "white",
        fontSize: 16,
      },
    },

    scales: {
      xAxes: [
        {
          //type: 'value',
          distribution: "series",
          ticks: {
            fontColor: "white",
            beginAtZero: true,
            maxticksLimit: 5,
          },
        },
      ],
      yAxes: [
        {
          scaleLabel: {
            display: true,
            labelString: "USO %",
            fontColor: "white",
          },
          ticks: {
            fontColor: "white",
            beginAtZero: true,
            suggestedMin: 0,
            suggestedMax: 30,
          },
        },
      ],
    },
    animation: {
      duration: 0,
    },
  },
};

var chart = new Chart(context, configuration);

//Função para obter os dados de temperatura do server
//Seria mais interessante fazer isso com WebSocket, porém para fins academicos, os dados serão atualizados via HTTP

//Esse atributo dentro do contexto serve para saber qual foi o último índice processado, assim eliminado os outros elementos na
//hora de montar/atualizar o gráfico
this.lastIndexTemp = 0;
this.time = 0;

function get_data() {
  var http = new XMLHttpRequest();
  http.open("GET", "http://localhost:3000/api", false);
  http.send(null);

  var obj = JSON.parse(http.responseText);
  console.log(obj);
  if (obj.data.length == 0) {
    return;
  }

  var _lastIndexTemp = this.lastIndexTemp;
  this.lastIndexTemp = obj.data.length;
  listTemp = obj.data.slice(_lastIndexTemp);

  listTemp.forEach((data) => {
    //Máximo de 60 itens exibidos no gráfico
    if (
      chart.data.labels.length == 10 &&
      chart.data.datasets[0].data.length == 10
    ) {
      chart.data.labels.shift();
      chart.data.datasets[0].data.shift();
    }

    chart.data.labels.push(this.time++);
    chart.data.datasets[0].data.push(parseFloat(data));
    chart.update();
  });
}

get_data();

function sendTemperature() {
  var http = new XMLHttpRequest();
  http.open("POST", "http://localhost:3000/api/sendData", false);
  http.send(null);
}

setInterval(() => {
  sendTemperature();
  get_data();
}, 4000);

// DISCO
// ---------------------------------------

context = document.getElementById("chart3").getContext("2d");
context.canvas.width = 1000;
context.canvas.height = 300;

var configuration = {
  type: "line",
  data: {
    datasets: [
      {
        label: "DISCO",
        type: "line",
        backgroundColor: ["#1111"],
        borderColor: ["#ff6347"],
      },
    ],
  },
  options: {
    legend: {
      labels: {
        fontColor: "white",
        fontSize: 16,
      },
    },
    scales: {
      xAxes: [
        {
          //type: 'value',
          distribution: "series",
          ticks: {
            fontColor: "white",
            beginAtZero: true,
            maxticksLimit: 5,
          },
        },
      ],
      yAxes: [
        {
          scaleLabel: {
            display: true,
            labelString: "USO %",
            fontColor: "white"
          },
          ticks: {
            fontColor: "white",
            beginAtZero: true,
            suggestedMin: 0,
            suggestedMax: 30,
          },
        },
      ],
    },
    animation: {
      duration: 0,
    },
  },
};

var chart = new Chart(context, configuration);

//Função para obter os dados de temperatura do server
//Seria mais interessante fazer isso com WebSocket, porém para fins academicos, os dados serão atualizados via HTTP

//Esse atributo dentro do contexto serve para saber qual foi o último índice processado, assim eliminado os outros elementos na
//hora de montar/atualizar o gráfico
this.lastIndexTemp = 0;
this.time = 0;

function get_data() {
  var http = new XMLHttpRequest();
  http.open("GET", "http://localhost:3000/api", false);
  http.send(null);

  var obj = JSON.parse(http.responseText);
  console.log(obj);
  if (obj.data.length == 0) {
    return;
  }

  var _lastIndexTemp = this.lastIndexTemp;
  this.lastIndexTemp = obj.data.length;
  listTemp = obj.data.slice(_lastIndexTemp);

  listTemp.forEach((data) => {
    //Máximo de 60 itens exibidos no gráfico
    if (
      chart.data.labels.length == 10 &&
      chart.data.datasets[0].data.length == 10
    ) {
      chart.data.labels.shift();
      chart.data.datasets[0].data.shift();
    }

    chart.data.labels.push(this.time++);
    chart.data.datasets[0].data.push(parseFloat(data));
    chart.update();
  });
}

get_data();

function sendTemperature() {
  var http = new XMLHttpRequest();
  http.open("POST", "http://localhost:3000/api/sendData", false);
  http.send(null);
}

setInterval(() => {
  sendTemperature();
  get_data();
}, 4000);
