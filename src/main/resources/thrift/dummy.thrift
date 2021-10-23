namespace * com.practice.thift.service


service DummyService {
    bool isUploadSuccessful(1: binary file);
}

exception Exception{
    1: i32 code,
    2: string description
}
