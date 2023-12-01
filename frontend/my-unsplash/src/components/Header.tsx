type Header = {
  addPhotoForm: boolean;
  setAddPhotoForm: React.Dispatch<React.SetStateAction<boolean>>;
};

export default function Header({ addPhotoForm, setAddPhotoForm }: Header) {
  return (
    <header className="pt-8 lg:px-24 xl:px-30 sm:px-20 flex">
      <img src="/my_unsplash_logo.svg" alt="Logo" />
      <form className="pl-6">
        <input
          className="py-[18px] bg-[url('/search.svg')] bg-no-repeat"
          type="text"
          placeholder="Search by name"
        />
      </form>
      <button
        onClick={() => setAddPhotoForm(!addPhotoForm)}
        className="ml-auto button-filter rounded-xl text-[#fff] text-base font-bold bg-button py-4 px-5"
      >
        Add a photo
      </button>
    </header>
  );
}
