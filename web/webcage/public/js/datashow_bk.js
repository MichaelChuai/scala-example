// Generated by CoffeeScript 1.10.0
(function() {
  var dataCol, ds;

  ds = [
    {
      key: 'NVD3',
      values: [
        {
          key: "Charts",
          _values: [
            {
              key: "Simple Line",
              type: "Historical",
              url: "http://novus.github.com/nvd3/ghpages/line.html"
            }, {
              key: "Scatter / Bubble",
              type: "Snapshot",
              url: "http://novus.github.com/nvd3/ghpages/scatter.html"
            }
          ]
        }, {
          key: "Chart Components",
          _values: [
            {
              key: "Legend",
              type: "Universal",
              url: "http://novus.github.com/nvd3/examples/legend.html"
            }
          ]
        }
      ]
    }
  ];

  dataCol = [
    {
      key: 'key',
      label: 'Name',
      showCount: true,
      width: '75%',
      type: 'text',
      classes: function(d) {
        if (d.url) {
          return 'clickable name';
        } else {
          return 'name';
        }
      },
      click: function(d) {
        if (d.url) {
          return window.location.href = d.url;
        }
      }
    }, {
      key: 'type',
      label: 'Type',
      width: '25%',
      type: 'text'
    }
  ];

  nv.addGraph(function() {
    var chart;
    chart = nv.models.indentedTree().columns(dataCol);
    return d3.select('#vis').datum(ds).call(chart);
  });

}).call(this);