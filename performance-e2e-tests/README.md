Gatling's SBT plugin demo
=========================

A simple project showing how to configure and use Gatling's SBT plugin to run Gatling simulations. 

This project uses SBT 0.13.11, which is available [here](http://www.scala-sbt.org/download.html) or through [Paul Phillips's sbt-extras script](https://github.com/paulp/sbt-extras).

Get the project
---------------

```bash
git clone https://github.com/gatling/gatling-sbt-plugin-demo.git && cd gatling-sbt-plugin-demo
```

Start SBT
---------
```bash
$ sbt
```

Run all simulations
-------------------

```bash
> gatling:test
```

Run a single simulation
-----------------------

```bash
> gatling:testOnly computerdatabase.BasicSimulation
```

List all tasks
--------------------

```bash
> tasks gatling -v
```
