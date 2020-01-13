namespace java thrift

service ThriftInsuranceService{
	string getData(),

	double calculate(1:string  herstellerName, 2:double distance)


}
